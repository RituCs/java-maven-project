#!/usr/bin/env groovy

pipeline {
    agent any
    tools{
    maven 'maven-3.9.9'
    } 
    stages {
        stage('test') {
            when {
               expression {
                BRANCH_NAME ==  "feature/add-tests"
               }
            }
            steps {
                script{
                    echo "Testing the application..."
                    sh 'mvn test'
                }
            }
        }
        stage('build jar') {
              when {
               expression {
                BRANCH_NAME ==  "main"
               }
            }
            steps {
                script{
                    echo "Building the application..."
                    sh 'mvn package'
                }
            }
        }
        stage('build image') {
            when {
               expression {
                BRANCH_NAME ==  "main"
               }
            }
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
            when {
               expression {
                BRANCH_NAME ==  "main"
               }
            }
            steps {
                    echo "Deploying the application..."
                    echo "Deploying the branch $BRANCH_NAME"
            }
        }
    }
}
