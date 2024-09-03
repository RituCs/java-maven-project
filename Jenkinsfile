#!/usr/bin/env groovy

pipeline {
    agent none
    parameters{
    choice(name: 'VERSION', choices: ['V1.0', 'V2.0', 'V3.0'], description:'')
    booleanParam(name: 'executeTests', defaultValue: true, description:'')
    } 
    stages {
        stage('build') {
            steps {
                script {
                    echo "Building the application..."
                }
            }
        }
        stage('test') {
            when{
               expression {
               params.executeTests
                }
            }
            steps {
                script {
                    echo "Testing the application..."
                }
            }
        }
        stage('deploy') {
            steps {
                script {
                    echo "Deploying the application..."
                    echo "deploying versions ${params.VERSION}"
                }
            }
        }
    }
}
