<?php

if (isset($_GET['nome'])&&isset($_GET['email'])) {

		//REST -> CRUD
		//REST POST -> create (C)
		//REST GET -> read (R)
		//REST PUT -> update (U)
		//REST DELET -> delete (D)

	//implement code to establish db connection and insert data
		$result = ['status' => 'OK'];
		echo json_encode($result);

}
	


?>