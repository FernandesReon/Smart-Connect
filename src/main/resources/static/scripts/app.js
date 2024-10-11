// Auto-hide Alert
window.addEventListener('DOMContentLoaded', (event) => {
    // Hide success alert after 5 seconds
    const successAlert = document.getElementById('successAlert');
    if (successAlert) {
        setTimeout(() => {
            successAlert.style.display = 'none';
        }, 5000); // 5 seconds
    }

    // Hide error alert after 5 seconds (optional)
    const errorAlert = document.getElementById('errorAlert');
    if (errorAlert) {
        setTimeout(() => {
            errorAlert.style.display = 'none';
        }, 5000); // 5 seconds
    }
});