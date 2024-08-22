plugins {
	id("com.android.application")
	id("kotlin-android")
}

android {
	compileSdk = 33
	
	defaultConfig {
		applicationId = "com.dsc.formbuilder"
		minSdk = 27
		targetSdk = 33
		versionCode = 1
		versionName = "1.0"
		
		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
		sourceCompatibility = JavaVersion.VERSION_1_8
		targetCompatibility = JavaVersion.VERSION_1_8
	}
	kotlinOptions {
		jvmTarget = "1.8"
	}
	buildFeatures {
		compose = true
	}
	composeOptions {
		kotlinCompilerExtensionVersion = rootProject.extra["compose_version"] as String
	}
	packagingOptions {
		resources {
			excludes += "/META-INF/{AL2.0,LGPL2.1}"
		}
	}
}

dependencies {
	
	implementation(project(":form-builder"))
	
	implementation("androidx.core:core-ktx:1.8.0")
	implementation("androidx.appcompat:appcompat:1.5.0")
	implementation("androidx.activity:activity-compose:1.5.1")
	implementation("com.google.android.material:material:1.6.1")
	implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.5.1")
	
	implementation("androidx.compose.ui:ui:${rootProject.extra["compose_version"]}")
	implementation("androidx.compose.material:material:${rootProject.extra["compose_version"]}")
	implementation("androidx.compose.animation:animation:${rootProject.extra["compose_version"]}")
	implementation("androidx.compose.ui:ui-tooling-preview:${rootProject.extra["compose_version"]}")
	
	debugImplementation("androidx.compose.ui:ui-tooling:${rootProject.extra["compose_version"]}")
	
	implementation("androidx.compose.material3:material3:1.0.0-beta01")
	implementation("androidx.compose.material3:material3-window-size-class:1.0.0-beta01")
}