buildscript {
	extra.apply {
		set(
			"kotlin_version",
			"1.7.0"
		)
		set(
			"compose_version",
			"1.2.0"
		)
	}
}
plugins {
	id("com.android.library") version "7.3.0" apply false
	id("org.jetbrains.kotlin.android") version "1.7.0" apply false
	id("org.jetbrains.dokka") version "1.7.0" apply false
}
