//
//  ViewController.kt
//  TodoList
//
//  Created by AHMED ALJOAID on 25/04/2018.
//  Copyright © 2018 AHMED ALJOAID. All rights reserved.
//

import kotlinx.cinterop.*
import platform.Foundation.*
import platform.UIKit.*
import platform.darwin.NSInteger

var list = mutableListOf<String>()

@ExportObjCClass
class ViewController(aDecoder: NSCoder) : UIViewController(aDecoder), UITableViewDelegateProtocol, UITableViewDataSourceProtocol {

    @ObjCOutlet
    lateinit var myTodoListView: UITableView

    override fun debugDescription() = this::class.simpleName!!

    override fun initWithCoder(aDecoder: NSCoder) = initBy(ViewController(aDecoder))

    override fun tableView(tableView: UITableView, cellForRowAtIndexPath: NSIndexPath): UITableViewCell {
        val cell = UITableViewCell(style = UITableViewCellStyle.UITableViewCellStyleDefault, reuseIdentifier = "cell")
        cell.text = list[cellForRowAtIndexPath.row.toInt()]
        return cell
    }


    override fun tableView(tableView: UITableView, numberOfRowsInSection: NSInteger): NSInteger {
        return list.size.toLong()
    }


    override fun tableView(tableView: UITableView, commitEditingStyle: UITableViewCellEditingStyle, forRowAtIndexPath: NSIndexPath) {

        if (commitEditingStyle == UITableViewCellEditingStyle.UITableViewCellEditingStyleDelete) {
            list.removeAt(forRowAtIndexPath.row.toInt())
            myTodoListView.reloadData()
        }
    }


    override fun viewDidAppear(animated: Boolean) {
        super.viewDidAppear(animated)
        myTodoListView.reloadData()
    }

}
