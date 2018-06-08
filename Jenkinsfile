#!/usr/bin/env groovy

node('linux') {
    stage 'Checkout'
    checkout scm

    stage 'Build + Unit test + SCA'
    sh 'chmod +x gradlew'
    sh './gradlew clean build --console=plain --no-daemon --stacktrace --rerun-tasks'

    sh "ls -l build/libs/"
    sh "ls -l build/resources/"
}