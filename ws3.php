<?php
  if(isset($_GET['nome']) && isset($_GET['email'])) {

    $meuarray = array();

    array_push($meuarray, array(
      'nome' => 'Joao',
      'morada' => 'Viana',
      'idade' => '27'
     ));

     array_push($meuarray, array(
       'nome' => 'manuel',
       'morada' => 'Porto',
       'idade' => '20'
      ));

      array_push($meuarray, array(
        'nome' => 'Pedro',
        'morada' => 'Aveiro',
        'idade' => '22'
       ));

       $result = [ 'status' => 'OK', 'dados' => $meuarray];
       echo json_encode($result);
  }
   ?>
