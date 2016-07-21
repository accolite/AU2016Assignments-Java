<?php
    $index = $_GET["index"];
    $data = file_get_contents ("images.json");
    $json = json_decode($data, true);
    echo json_encode($json[$index]);    
?>