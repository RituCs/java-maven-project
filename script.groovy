def testProject(){
     echo "Testing the application..."
     sh 'mvn test'
}

def buildJar(){
     echo "Building the application..."
     sh 'mvn package'
}

def buildImage(){
    echo "Building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
    sh 'docker build -t ritucs/demo-project:V2.0 .'
    sh 'echo $PASS | docker login -u $USER --password-stdin'
    sh 'docker push ritucs/demo-project:V2.0'
}

def deploy(){
    echo "Deploying the application.."
    echo "Deploying the branch $BRANCH_NAME"
} 

return this