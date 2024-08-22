plugins {
	id("com.android.library")
	id("org.jetbrains.kotlin.android")
	id("maven-publish")
	id("org.jetbrains.dokka")
}

android {
	compileSdk = 32
	
	defaultConfig {
		minSdk = 21
		targetSdk = 32
		
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
		sourceCompatibility = JavaVersion.VERSION_1_8
		targetCompatibility = JavaVersion.VERSION_1_8
	}
	
	kotlinOptions {
		jvmTarget = "1.8"
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
		kotlinCompilerExtensionVersion = rootProject.extra["compose_version"] as String
	}
}

dependencies {
	// Testing
	testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
	testImplementation("org.mockito.kotlin:mockito-kotlin:4.0.0")
	testImplementation("org.junit.jupiter:junit-jupiter-params:5.8.1")
	
	// Compose
	implementation("androidx.activity:activity-compose:1.5.1")
	
	// Kotlin reflection
	implementation("org.jetbrains.kotlin:kotlin-reflect:${rootProject.extra["kotlin_version"]}")
}



afterEvaluate {
	publishing {
		publications {
			create<MavenPublication>("release") {
				from(components["release"])
				
				groupId = "com.github.dsc-jkuat"
				artifactId = "form-builder"
				version = "1.0.1"
			}
		}
	}
}