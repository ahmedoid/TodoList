//
//  AppDelegate.kt
//  TodoList
//
//  Created by AHMED ALJOAID on 25/04/2018.
//  Copyright © 2018 AHMED ALJOAID. All rights reserved.
//

import kotlinx.cinterop.*
import platform.UIKit.*

class AppDelegate : UIResponder(), UIApplicationDelegateProtocol {
    companion object : UIResponderMeta(), UIApplicationDelegateProtocolMeta {}

    override fun init() = initBy(AppDelegate())

    private var _window: UIWindow? = null
    override fun window() = _window
    override fun setWindow(window: UIWindow?) { _window = window }
}
