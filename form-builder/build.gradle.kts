plugins {
	alias(libs.plugins.android.library)
	alias(libs.plugins.jetbrains.kotlin.android)
	alias(libs.plugins.jetbrains.dokka)
	id("maven-publish")
}

android {
	compileSdk = libs.versions.compileSdk.get().toInt()
	
	defaultConfig {
		minSdk = libs.versions.minSdk.get().toInt()
		targetSdk = libs.versions.targetSdk.get().toInt()
		
		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		consumerProguardFiles("consumer-rules.pro")
	}
	
	buildTypes {
		getByName("release") {
			isMinifyEnabled = false
			proguardFiles(
				getDefaultProguardFile("proguard-android-optimize.txt"),
				"proguard-rules.pro"
			)
		}
	}
	
	compileOptions {
		sourceCompatibility(libs.versions.jvmTarget.get())
		targetCompatibility(libs.versions.jvmTarget.get())
	}
	
	kotlinOptions {
		jvmTarget = libs.versions.jvmTarget.get()
	}
	
	testOptions {
		unitTests {
			all {
				it.useJUnitPlatform()
			}
		}
	}
	
	buildFeatures {
		compose = true
	}
	
	composeOptions {
		kotlinCompilerExtensionVersion = libs.versions.compose.get()
	}
}

dependencies {
	// Testing
	testImplementation(libs.junit.jupiter)
	testImplementation(libs.mockito.kotlin)
	testImplementation(libs.junit.jupiter.params)
	
	// Compose
	implementation(libs.androidx.activity.compose)
	
	// Kotlin reflection
	implementation(libs.jetbrains.kotlin.reflection)
}



afterEvaluate {
	publishing {
		publications {
			create<MavenPublication>("release") {
				from(components["release"])
				
				groupId = "com.github.dsc-jkuat"
				artifactId = "form-builder"
				version = libs.versions.libVersionName.get()
			}
		}
	}
}