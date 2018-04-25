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

@ExportObjCClass
class CreateTodoViewController(aDecoder: NSCoder) : UIViewController(aDecoder) {

    @ObjCOutlet
    lateinit var myTodoText: UITextField

    override fun debugDescription() = this::class.simpleName!!

    override fun initWithCoder(aDecoder: NSCoder) = initBy(CreateTodoViewController(aDecoder))


    @ObjCAction
    fun saveTodo() {
        if (!myTodoText.text?.isEmpty()!!) {
            list.add(myTodoText.text!!)
            myTodoText.text = ""
        }
    }

}
