def call(String repoUrl, String branch, String credId = null) {

    if (credId == null) {

        // PUBLIC REPO
        sh """
            git clone -b ${branch} ${repoUrl}
        """

    } else {

        // PRIVATE REPO
        withCredentials([usernamePassword(
            credentialsId: credId,
            usernameVariable: 'GIT_USER',
            passwordVariable: 'GIT_PASS'
        )]) {

            sh """
                git clone -b ${branch} https://${GIT_USER}:${GIT_PASS}@${repoUrl.replace('https://', '')}
            """
        }
    }

    echo "Repo cloned: ${repoUrl}"
    echo "Branch: ${branch}"
}
