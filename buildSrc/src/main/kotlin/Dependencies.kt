object Versions {
    //core
    const val KOTLIN = "1.3.60"
    val WIRE_AUDIO = System.getenv("AUDIO_VERSION") ?: "1.209.0@aar"
    const val WIRE_TRANSLATIONS = "1.+"

    //build
    const val COROUTINES = "1.3.2"
    const val WORK_MANAGER = "2.0.1"

    //testing
    const val JUNIT = "4.12"
    const val MOCKITO = "3.1.0"
    const val KLUENT = "1.14"
    const val ANDROIDX_TEST_CORE = "2.1.0"
    const val ANDROIDX_TEST_JUNIT = "1.1.1"
}

object CoreDependencies {
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.KOTLIN}"
    val wire_audio_notifications = "com.wire:audio-notifications:${Versions.WIRE_AUDIO}"
    val wire_translations = "com.wire:wiretranslations:${Versions.WIRE_TRANSLATIONS}"
}

object BuildDependencies {
    val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES}"
    val work_manager = "androidx.work:work-runtime:${Versions.WORK_MANAGER}"
}

object TestDependencies {
    val junit = "junit:junit:${Versions.JUNIT}"
    val mockito_core = "org.mockito:mockito-core:${Versions.MOCKITO}"
    val mockito_inline = "org.mockito:mockito-inline:${Versions.MOCKITO}"
    val kluent = "org.amshove.kluent:kluent:${Versions.KLUENT}"
    val coroutines_test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.COROUTINES}"
    val androidx_test_core = "androidx.arch.core:core-testing:${Versions.ANDROIDX_TEST_CORE}"
    val androidx_test_junit = "androidx.test.ext:junit:${Versions.ANDROIDX_TEST_JUNIT}"
    val androidx_test_rules = "androidx.test:rules:${Versions.ANDROIDX_TEST_JUNIT}"
    val androidx_work_manager_test = "androidx.work:work-testing:${Versions.WORK_MANAGER}"
}

object LegacyDependencies {
    const val SCALA_MAJOR_VERSION = "2.11"
    const val SCALA_VERSION = SCALA_MAJOR_VERSION.plus(".12")

    //build
    val scala_library = "org.scala-lang:scala-library:$SCALA_VERSION"
    val scala_reflect = "org.scala-lang:scala-reflect:$SCALA_VERSION"
    val scala_shapeless = "com.chuusai:shapeless_$SCALA_MAJOR_VERSION:2.3.3"

    //test
    val scala_test = "org.scalatest:scalatest_${SCALA_MAJOR_VERSION}:3.0.5"
}
