package com.zestworks.addtask


infix fun <T> T.shouldBe(any: Any?) {
    assert(any == this)
}