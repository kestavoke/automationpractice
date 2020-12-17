node {
    stage('Git checkout') { // for display purposes
        git 'https://kestavoke@bitbucket.org/kestavoke/automationpractice.git'
    }
    stage('Smoke') {
        try {
            sh "mvn clean verify -Dtags='type:Smoke'"
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
            sh "mvn verify -Dtags='type:Regression'"
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
        sh 'ln -s tests/test-results-unit.xml $WORKSPACE'
        junit "test-results-unit.xml"
    }
}