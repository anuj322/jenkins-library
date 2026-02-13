def call(String recipient = "yourmail@example.com") {
    try {
        emailext(
            to: recipient,
            subject: "❌ Jenkins Build Failed: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
            body: """
            <h2 style="color:red;">Build Failed ❌</h2>

            <b>Job Name:</b> ${env.JOB_NAME} <br>
            <b>Build Number:</b> ${env.BUILD_NUMBER} <br>
            <b>Build URL:</b> <a href="${env.BUILD_URL}">${env.BUILD_URL}</a> <br>

            <br>
            Please check the logs immediately.
            """,
            mimeType: 'text/html'
        )
    } catch (err) {
        echo "Email sending failed: ${err}"
    }
}
