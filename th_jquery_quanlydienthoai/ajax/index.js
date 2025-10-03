function addNewSmartPhone() {
  //lấy dữ liệu từ form html
  let producer = $("#producer").val();
  let model = $("#model").val();
  let price = $("#price").val();
  let newSmartphone = {
    producer: producer,
    model: model,
    price: price,
  };
  // gọi phương thức ajax
  $.ajax({
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
    type: "POST",
    data: JSON.stringify(newSmartphone),
    //tên API
    url: "http://localhost:8080/api/smartphones",
    //xử lý khi thành công
    success: successHandler,
  });
  //chặn sự kiện mặc định của thẻ
  event.preventDefault();
}

function updateSmartPhone() {
  //lấy dữ liệu từ form html
  let idSmartphone = $("#idSmartphone").val();
  let producer = $("#producerUpdate").val();
  let model = $("#modelUpdate").val();
  let price = $("#priceUpdate").val();
  let newSmartphone = {
    producer: producer,
    model: model,
    price: price,
  };
  // gọi phương thức ajax
  $.ajax({
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
    type: "PUT",
    data: JSON.stringify(newSmartphone),
    //tên API
    url: `http://localhost:8080/api/smartphones/${idSmartphone}`,
    //xử lý khi thành công
    success: successHandler,
  });
  //chặn sự kiện mặc định của thẻ
  event.preventDefault();
}

function successHandler() {
  $.ajax({
    type: "GET",
    url: "http://localhost:8080/api/smartphones",
    success: function (data) {
      let content =
        '<table id="display-list" border="1"><tr>' +
        "<th>Producer</th>" +
        "<th>Model</th>" +
        "<th>Price</th>" +
        "<th>Delete</th>" +
        "<th>Update</th>" +
        "</tr>";
      for (let i = 0; i < data.length; i++) {
        content += getSmartphone(data[i]);
      }
      content += "</table>";
      document.getElementById("smartphoneList").innerHTML = content;
      document.getElementById("smartphoneList").style.display = "block";
      document.getElementById("add-smartphone").style.display = "none";
      document.getElementById("update-smartphone").style.display = "none";
      document.getElementById("title").style.display = "block";

      document.getElementById("display").style.display = "none";
      document.getElementById("display-create").style.display = "inline-block";
    },
  });
}

function back() {
  successHandler();
}

function displayFormCreate() {
  document.getElementById("smartphoneList").style.display = "none";
  document.getElementById("add-smartphone").style.display = "block";
  document.getElementById("display-create").style.display = "none";
  document.getElementById("title").style.display = "none";
}

function displayFormUpdate() {
  document.getElementById("smartphoneList").style.display = "none";
  document.getElementById("update-smartphone").style.display = "block";
  document.getElementById("display-create").style.display = "none";
  document.getElementById("title").style.display = "none";
}

function getSmartphone(smartphone) {
  return (
    `<tr><td >${smartphone.producer}</td><td >${smartphone.model}</td><td >${smartphone.price}</td>` +
    `<td class="btn"><button class="deleteSmartphone" onclick="deleteSmartphone(${smartphone.id})">Delete</button></td>` +
    `<td class="btn"><button class="deleteSmartphone" onclick="updateSmartphone(${smartphone.id})">Update</button></td></tr>`
  );
}

function updateSmartphone(id) {
  
  $.ajax({
    type: "GET",
    url: `http://localhost:8080/api/smartphones/detail/${id}`,
    success: function (data) {
      console.log(data);
      document.getElementById("idSmartphone").value = data.id;
      document.getElementById("producerUpdate").value = data.producer;
      document.getElementById("modelUpdate").value = data.model;
      document.getElementById("priceUpdate").value = data.price;
    },
  });
  displayFormUpdate();
}

function deleteSmartphone(id) {
  $.ajax({
    type: "DELETE",
    url: `http://localhost:8080/api/smartphones/${id}`,
    success: successHandler,
  });
}
