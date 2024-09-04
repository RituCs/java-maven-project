#!/usr/bin/env groovy
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
                   gv.testProject()
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
                   gv.buildJar()
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
                  gv.buildImage()
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
                gv.deploy()
            }
        }
    }
}
