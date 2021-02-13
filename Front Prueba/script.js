window.onload = consultar();
resp = "";
$(document).ready(function () {

    $('[name="checks[]"]').click(function () {

        var arr = $('[name="checks[]"]:checked').map(function () {
            return this.value;
        }).get();

    });

});
function consultar() {
    fetch('http://localhost:8080/info/listarDatos')
        .then(response => response.json())
        .then(listar)
}
function listar(response) {
    let data = response;
    resp = data;
    console.log(data.listTabla1)
    data.listTabla1.forEach((element, index) => {

        element.status === false ? element.status = "sin procesar" : element.status = "procesado";

        console.log(element)
        tr = document.createElement("tr")
        tr.setAttribute("class", element.id);

        td = document.createElement("td")
        check = document.createElement("input")
        check.setAttribute("type", "checkbox");
        check.setAttribute("class", "form-check-input");
        check.setAttribute("value", [index]);
        if (element.status === "procesado") {
            check.disabled = true
        }
        tr.appendChild(td)
        td.appendChild(check)



        td = document.createElement("td")
        nombre = document.createTextNode(element.nombre)
        tr.appendChild(td)
        td.appendChild(nombre)

        td2 = document.createElement("td")
        apellidos = document.createTextNode(element.apellido)
        tr.appendChild(td2)
        td2.appendChild(apellidos)

        td3 = document.createElement("td")
        estado = document.createTextNode(element.status)
        tr.appendChild(td3)
        td3.appendChild(estado)

        tbody = document.getElementById("tbody");
        tbody.appendChild(tr);
    });
    console.log(data)
}
function insert() {
    event.preventDefault()
    let name = document.getElementById('names').value;
    let lastNames = document.getElementById('lastNames').value;
    if (name === '' || lastNames === '') {
        alert("Debe llenar los campos")
        return;
    }
    console.log(name, lastNames)
    fetch('http://localhost:8080/info/GuardarInfo',
        {
            method: 'POST',
            body: JSON.stringify({
                nombre: name,
                apellido: lastNames,
                status: false
            }),
            headers: {
                "Content-type": "application/json"
            }
        }).then(response => response.json())
        .then(location.reload())
}
$(document).ready(function () {
    $('#enviar').click(function () {
        var selected = [];
        $('#formid input[type=checkbox]').each(function () {
            if (this.checked) {
                selected.push($(this).val());
            }
        });

        if (selected != '')
            procesar(selected);
        else
            alert('Debes seleccionar al menos una opción.');

        return false;
    });
});
function procesar(options) {
    arrayFiltro = []
    options.forEach((option, index) => {
        let respuesta = resp.listTabla1;
        let item = respuesta[Number(option)];
        arrayFiltro.push(item);
    });
    arrayFiltro.forEach(element => {
        element.status = true;
    });
    console.log(arrayFiltro);

    console.log(JSON.stringify({ "listTabla1": arrayFiltro }))
    fetch('http://localhost:8080/info/ProcesarDatos',
        {
            method: 'PUT',
            body: JSON.stringify({ "listTabla1": arrayFiltro }),
            headers: {
                "Content-type": "application/json"
            }
        }).then(response => response.json())
        .then(listar(response))
}