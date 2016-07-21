<?php

$number =$_REQUEST["index"];
$ret;

switch($number)
{
	case 1:
		$ret = "[{\"url\":\"images/british_museum.jpg\",\"desc\":\"The British Museum\",\"info\":\"exhibits the works of man from prehistoric to modern times, from around the world. Highlights include the Rosetta Stone, the Parthenon sculptures and the mummies in the Ancient Egypt collection\",
\"webpage\":\"www.visitlondon.com/things-to-do/sightseeing/london-attraction/top-ten-attractions\"}]";
		break;
	case 2:
		$ret = "[{\"url\":\"images/national_gallery.jpg\",\"desc\":\"The National Gallery\",\"info\":\"vast space filled with Western European paintings from the 13th to the 19th centuries. Find works by masters such as Van Gogh, da Vinci, Botticelli, Constable, Renoir, Titian and Stubbs\",\"webpage\":\"www.visitlondon.com/things-to-do/sightseeing/london-attraction/top-ten-attractions\"}]";
		break;
	case 3:
		$ret = "[{\"url\":\"images/natural_history_museum.jpg\",\"desc\":\"The Natural History Museum\",\"info\":\"boasts a collection of the biggest, tallest and rarest animals in the world. See a life-sized blue whale, a 40-million-year-old spider, and the beautiful Central Hall.\",\"webpage\":\"www.visitlondon.com/things-to-do/sightseeing/london-attraction/top-ten-attractions\"}]";
		break;
	case 4:
		$ret = "[{\"url\":\"images/tower_of_london.jpg\",\"desc\":\"the Tower of London\",\"info\":\"Discover its 900-year history as a royal palace, prison and place of execution, arsenal, jewel house and zoo! Gaze up at the White Tower, tiptoe through a medieval kings bedchamber and marvel at the Crown Jewels\",\"webpage\":\"www.visitlondon.com/things-to-do/sightseeing/london-attraction/top-ten-attractions\"}]";
		break;
	case 5 :
		$ret = "[{\"url\":\"images/victoria_albert_museum.jpg\",\"desc\":\"The Victoria Albert Museum\",\"info\":\"celebrates art and design with 3,000 years worth of amazing artefacts from around the world. A real treasure trove of goodies, you never know what youll discover next: furniture, paintings, sculpture, metalwork and textile\",\"webpage\":\"www.visitlondon.com/things-to-do/sightseeing/london-attraction/top-ten-attractions\"}]";
		break;
}
echo $ret;
?>