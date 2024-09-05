#!/usr/bin/env groovy
@Library("jenkins-shared-library")
def gv
pipeline {
    agent any
    tools{
    maven 'maven-3.9.9'
    } 
    stages {
         stage('init') {
            steps {
                script{
                   gv = load "script.groovy"
                }
            }
        }
        stage('test') {
            when {
               expression {
                BRANCH_NAME ==  "feature/add-tests"
               }
            }
            steps {
                script{
                    buildTest()
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
                    buildJar()
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
                   buildImage()
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
                script{
                 gv.deploy()
                }
            }
        }
    }
}
