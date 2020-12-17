node {
    stage('Git checkout') { // for display purposes
        git 'https://kestavoke@bitbucket.org/kestavoke/automationpractice.git'
    }
    stage('Smoke') {
        try {
            def mvnHome = tool name: 'Apache Maven 3.6.2', type: 'maven'
            sh "${mvnHome}/bin/mvn clean verify -Dcucumber.options='--tags @Smoke'"
        } catch (err) {

        } finally {
            publishHTML (target: [
                    reportDir: 'target/site/serenity',
                    reportFiles: 'index.html',
                    reportName: "Smoke tests report"
            ])
        }
    }
    stage('Regression') {
        try {
            def mvnHome = tool name: 'Apache Maven 3.6.2', type: 'maven'
            sh "${mvnHome}/bin/mvn clean verify -Dcucumber.options='--tags @Regression'"
        } catch (err) {

        } finally {
            publishHTML (target: [
                    reportDir: 'target/site/serenity',
                    reportFiles: 'index.html',
                    reportName: "Regression tests report"
            ])
        }
    }
    stage('Results') {
        junit '**/target/failsafe-reports/*.xml'
    }
}