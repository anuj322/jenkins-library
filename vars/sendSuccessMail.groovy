def call(String recipient = "yourmail@example.com") {
    try {
        emailext(
            to: recipient,
            subject: "✅ Build Successful: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
            body: """
            <h2 style="color:green;">Build Successful ✅</h2>

            <b>Job Name:</b> ${env.JOB_NAME} <br>
            <b>Build Number:</b> ${env.BUILD_NUMBER} <br>
            <b>Status:</b> SUCCESS <br>
            <b>Build URL:</b> <a href="${env.BUILD_URL}">${env.BUILD_URL}</a> <br>

            <br>
            Great job! 🚀
            """,
            mimeType: 'text/html'
        )
    } catch (err) {
        echo "Success email not sent: ${err}"
    }
}
