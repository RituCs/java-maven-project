#!/usr/bin/env groovy
@Library('jenkins-shared-library')
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
            steps {
                script{
                  buildTest()
                }
            }
        }
        stage('build jar') {
            steps {
                script{
                    buildJar()
                }
            }
        }
        stage('build and push image') {
            steps {
                script{
                   buildImage 'ritucs/demo-project:V7.0'
                   dockerPush 'ritucs/demo-project:V7.0'
                    }
                }
            }
        stage('deploy') {
            steps {
                script{
                 gv.deploy()
                }
            }
        }
    }
}
