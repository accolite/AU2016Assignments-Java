<?php
$num=$_REQUEST["number"];
$s1="{\"url\":\"img1.jpg\",\"webpage\":\"dsvdsv\",\"description\":\"Wallpaper1\",\"details\":\"Size-HD\"}";
$s2="{\"url\":\"img2.jpg\",\"webpage\":\"sdvsd\",\"description\":\"Wallpaper2\",\"details\":\"Size-HD\"}";
$s3="{\"url\":\"img3.jpg\",\"webpage\":\"dbsfbs\",\"description\":\"Wallpaper3\",\"details\":\"Size-HD\"}";
$s4="{\"url\":\"img4.jpg\",\"webpage\":\"gnfddfbs\",\"description\":\"Wallpaper4\",\"details\":\"Size-HD\"}";
switch($num){
	case 0:
		echo $s1;
		break;
	case 1:
		echo $s2;
		break;
	case 2:
		echo $s3;
		break;
	case 3:
		echo $s4;
		break;
	default:
        echo $s1;

}

?>