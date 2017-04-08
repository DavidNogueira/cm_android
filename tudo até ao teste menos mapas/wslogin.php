<?php


if (isset($_GET['nome'])&&isset($_GET['pass'])) {

	if($_GET['nome']=="manu" && $_GET['pass']=="12"){
		$result = ['status' => 'OK'];

	}else{
		$result = ['status' => 'NO'];
		

	}

echo json_encode($result);
	

}
	

?>