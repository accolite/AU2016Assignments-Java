<?php
$pgno = $_REQUEST["page"];
$retvalue;
switch ($pgno) {
	case 1:
		$retvalue = "[{\"src\":\"img/img1.jpg\", \"imgid\": \"101\"}]";
		break;
	case 2:
		$retvalue = "[{\"src\":\"img/img2.jpg\", \"imgid\": \"102\"}]";
		break;
	case 3:
		$retvalue = "[{\"src\":\"img/img3.jpg\", \"imgid\": \"103\"}]";
		break;	
	case 4:
		$retvalue = "[{\"src\":\"img/img4.jpg\", \"imgid\": \"104\"}]";
		break;	
	case 5:
		$retvalue = "[{\"src\":\"img/img5.jpg\", \"imgid\": \"105\"}]";
		break;
}
echo $retvalue;
?>