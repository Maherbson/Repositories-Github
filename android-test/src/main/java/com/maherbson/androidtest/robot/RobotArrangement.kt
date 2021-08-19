package com.maherbson.androidtest.robot

import org.koin.test.KoinTest

interface RobotArrangement<out A : RobotAssertion, out B : RobotAction> : KoinTest