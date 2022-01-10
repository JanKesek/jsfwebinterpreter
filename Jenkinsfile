pipeline {
    agent any

    triggers {
        pollSCM('H/5 * * * *')
    }
    stages {
        stage('Test') {
                    steps {
                        sh 'mvn test'
                    }
        }
    }
    post {
            success {
                    emailext to: 'jakesek@wp.pl',
                        body: "BUILD OK! : ${env.BUILD_URL}",
                        recipientProviders: [brokenBuildSuspects()],
                        subject: "Failed build: ${currentBuild.fullDisplayName}"
                  }

        failure {
                emailext to: 'jakesek@wp.pl',
                    body: "Failed build: ${env.BUILD_URL}",
                    recipientProviders: [brokenBuildSuspects()],
                    subject: "Failed build: ${currentBuild.fullDisplayName}"
              }
   }
}