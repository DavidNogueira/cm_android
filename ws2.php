<?php

if (isset($_POST['nome'])&&isset($_POST['email'])) {



if ($_SERVER['REQUEST_METHOD']==='POST') {

		$result = ['status' => 'inserido com sucesso'];
		echo json_encode($result);

}
if ($_SERVER['REQUEST_METHOD']==='PUT') {


		$result = ['status' => 'actualizado com sucesso'];
		echo json_encode($result);

	}
}


?>