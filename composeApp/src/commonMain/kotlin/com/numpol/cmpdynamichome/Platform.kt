package com.numpol.cmpdynamichome

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform