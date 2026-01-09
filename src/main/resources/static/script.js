const apiUrl = "http://localhost:8080/students";

// Load students on page load
window.onload = loadStudents;

function loadStudents() {
    fetch(apiUrl)
        .then(res => res.json())
        .then(data => {
            let table = "";
            data.forEach(s => {
                table += `
                    <tr>
                        <td>${s.id}</td>
                        <td>${s.name}</td>
                        <td>${s.email}</td>
                        <td>${s.course}</td>
                    </tr>`;
            });
            document.getElementById("studentTable").innerHTML = table;
        });
}

// Save student
document.getElementById("studentForm").addEventListener("submit", function (e) {
    e.preventDefault();

    const student = {
        name: name.value,
        email: email.value,
        course: course.value
    };

    fetch(apiUrl, {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(student)
    })
        .then(() => {
            loadStudents();
            this.reset();
        });
});
