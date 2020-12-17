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

        stage ('Execute Tests') {
                    steps {
                        withMaven(maven : 'maven_3_6_2') {
                            sh "clean test verify -Dcucumber.option='-tags @Regression' -Dwebdriver.base.url=$usr -Dusr=$user -Dpwd=$password"


                            publishHTML (target: [
                                         reportDir: 'target/site/serenity',
                                         reportFiles: 'index.html',
                                         reportName: "Regression tests report"
                                                ])
                       }
                    }
                }

        stage ('Quality Analysis') {
                    steps {
                         withMaven(maven : 'maven_3_6_2') {

                        }
                    }
                 }
                 stage ('Post Actions') {
                                     steps {
                                          withMaven(maven : 'maven_3_6_2') {

                                         }
                                     }
                                  }
        }

}