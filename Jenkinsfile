#!/usr/bin/env groovy

pipeline {
    agent none
    tools{
    maven 'maven-3.9.9'
    } 
    stages {
        stage('build jar') {
            steps {
                script{
                    echo "Building the application..."
                    sh 'mvn package'
                }
            }
        }
        stage('build image') {
            steps {
                script{
                    echo "Building the docker image..."
                    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                    sh 'docker build -t ritucs/demo-project:V2.0 .'
                    sh 'echo $PASS | docker login -u $USER --password-stdin'
                    sh 'docker push ritucs/demo-project:V2.0'
                    }
                }
            }
        }
        stage('deploy') {
            steps {
                    echo "Deploying the application..."
            }
        }
    }
}
