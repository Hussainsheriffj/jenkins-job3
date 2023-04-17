//for the first Jenkisfile

// def buildApp(){
//     echo 'building the application...'
// }

// def testApp(){
//     echo 'testing the application...'
// }

// def deployApp(){
//     echo 'deplying the application...'
//     echo "deploying version ${params.VERSION}"
// }
// return this

//for the second Jenkins file
def buildJar(){
    echo 'building the application...'
    sh 'mvn package'
}

def buildImage(){
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t hussainsheriffj/demo-app:jma-2.1 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push hussainsheriffj/demo-app:jma-2.1'
    }
}

def deployApp(){
    echo 'deplying the application...'
}
return this