pipeline {
    agent any

    stages {
        stage ('Compile Stage') {
            steps {
                withMaven(maven : 'maven_3_6_2') {
                    sh 'mvn clean compile'
                }
            }
        }

        stage('Execute Tests') {
        steps {
                try {
                withMaven(maven : 'maven_3_6_2') {
                  sh "mvn clean verify -Dcucumber.options='--tags @Regression'"
                }
                } catch (err) {

                } finally {
                    publishHTML (target: [
                            reportDir: 'target/site/serenity',
                            reportFiles: 'index.html',
                            reportName: "Smoke tests report"
                    ])
                }
                }
            }

        stage ('Deployment Stage') {
                    steps {
                         withMaven(maven : 'maven_3_6_2') {
                             sh 'mvn deploy'
                        }
                    }
                 }
         }

}