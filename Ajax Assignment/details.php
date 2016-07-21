<?php
$imgid = $_REQUEST["imgid"];
$retvalue;
switch ($imgid) {
	case 101:
		$retvalue = "[{\"desc\":\"img desc1\",\"refurl\":\"www.ref1.com\",\"detail\":\"Details of image 1\"}]";
		break;
	case 102:
		$retvalue = "[{\"desc\":\"img desc2\",\"refurl\":\"www.ref2.com\",\"detail\":\"Details of image 2\"}]";
		break;
	case 103:
		$retvalue = "[{\"desc\":\"img desc3\",\"refurl\":\"www.ref3.com\",\"detail\":\"Details of image 3\"}]";
		break;	
	case 104:
		$retvalue = "[{\"desc\":\"img desc4\",\"refurl\":\"www.ref4.com\",\"detail\":\"Details of image 4\"}]";
		break;	
	case 105:
		$retvalue = "[{\"desc\":\"img desc5\",\"refurl\":\"www.ref5.com\",\"detail\":\"Details of image 5\"}]";
		break;
}
echo $retvalue;
?>