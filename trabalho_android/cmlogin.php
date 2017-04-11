<?php

    $servername = "localhost";
    $username = "root";
    $password = "root";
    $dbname = "cm_android_db";
    $conn = null;
        // $this->conn = new mysqli_connect($this->servername, $this->username, $this->password, $this->dbname);
        $conn = new mysqli($servername,$username, $password);
        if ($conn->connect_error) {
            die("Connection failed: " . $conn->connect_error);
        }



if (isset($_GET['nome'])&&isset($_GET['pass'])) {

    $sql = "select id_utilizador, password from cm_android_db.Utilizador where id_utilizador='" .$_GET['nome']. "' and password='" .$_GET['pass']. "';";

    $result = $conn->query($sql);

    if($result->num_rows > 0){
        $result = ['status' => 'OK'];
    }else{
        $result = ['status' => 'NO'];
    }	

    echo json_encode($result);
	

}
	mysqli_close($conn);

?>