<?php


if (isset($_POST['nome'])) {

	if($_POST['nome']=="Joao"){
		$result = ['idade' => '27'];

	} else if($_POST['nome']=="manuel"){
		$result = ['idade' => '20'];

	}} else if($_POST['nome']=="Pedro"){
		$result = ['idade' => '20'];

	}

echo json_encode($result);
	

}
	

?>