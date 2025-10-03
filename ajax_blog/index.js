function showList() {
  $.ajax({
    type: "GET",
    url: "http://localhost:8080/api/blog",
    success: function (data) {
      let content = `<table class="table">
        <thead>
          <tr>
            <th scope="col">Title</th>
            <th scope="col">Content</th>
            <th scope="col">Author</th>
            <th scope="col">Action</th>
          </tr>
        </thead>
        <tbody>
          `;
      for (let i = 0; i < data.length; i++) {
        content += getBlog(data[i]);
      }
      content += "</tbody></table>";
      document.getElementById("blogList").innerHTML = content;
      document.getElementById("formUpdate").style.display = "none";
    },
  });
}

function showGiaoDien() {
  document.getElementById("btnAdd").style.display = "inline-block";
  document.getElementById("blogList").style.display = "block";
  document.getElementById("formUpdate").style.display = "none";
}

function getBlog(blog) {
  return (
    `<tr><td >${blog.title}</td>
    <td >${blog.content}</td>
    <td >${blog.author}</td>` +
    `<td class="btn"><button class="btn btn-primary" onclick="updateBlog(${blog.id})">Update</button></td>` +
    `<td class="btn"><button class="btn btn-secondary" onclick="deleteBlog(${blog.id})">Delete</button></td>
    </tr>`
  );
}

function updateBlog(id) {
  $.ajax({
    type: "GET",
    url: `http://localhost:8080/api/blog/${id}`,
    success: function (data) {
      console.log(data);
      document.getElementById("title").value = data.title;
      document.getElementById("content").value = data.content;
      document.getElementById("author").value = data.author;
      document.getElementById("idUpdate").value = id;
    },
  });
  document.getElementById("btnAdd").style.display = "none";
  document.getElementById("blogList").style.display = "none";
  document.getElementById("formUpdate").style.display = "inline-block";
}

function update() {
  let idUpdate = $("#idUpdate").val();
  let title = $("#title").val();
  let content = $("#content").val();
  let author = $("#author").val();

  let newBlog = {
    title: title,
    content: content,
    author: author,
  };
  // gọi phương thức ajax
  $.ajax({
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
    type: "PUT",
    data: JSON.stringify(newBlog),
    //tên API
    url: `http://localhost:8080/api/blog/${idUpdate}`,
    //xử lý khi thành công
    success: showGiaoDien,
  });
}

function deleteBlog(id) {
  $.ajax({
    type: "DELETE",
    url: `http://localhost:8080/api/blog/${id}`,
    success: showList,
  });
}

showList();
