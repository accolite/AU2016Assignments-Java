<?php

$action = $_REQUEST['action'];
$current = $_REQUEST['current'];

$json_string = file_get_contents('image-store.json');


$json = json_decode($json_string,true);


//For show more just return detail
if($action=='showMore'){
	echo json_encode(array('detail'=>$json['images'][$current-1]['detail']));
}
//For next button, return url(src), alt and caption for image
elseif($action=='next'){
	$current = $current+1;
	echo json_encode(array('url' => $json['images'][$current-1]['url'], 'alt' => $json['images'][$current-1]['alt'], 
		'caption' => $json['images'][$current-1]['caption']));
}
//Same for previous
elseif ($action=='previous') {
	$current = $current-1;
	echo json_encode(array('url' => $json['images'][$current-1]['url'], 'alt' => $json['images'][$current-1]['alt'], 
		'caption' => $json['images'][$current-1]['caption']));
}



?>