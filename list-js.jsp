<script>
	//위도
	var lon = 37.559718;
	
	//경도
	var lat = 126.971120;
	
	//leaflet 지도 띄우기 (EPSG : 4326)
	var leafletMap = L.map('leafletMap').setView([lon, lat], 14)

	L.tileLayer('http://api.vworld.kr/req/wmts/1.0.0/{api 인증키}/Base/{z}/{y}/{x}.png').addTo(leafletMap);

	//마커추가
	leafletAddMarker(lon, lat);
	
	//폴리곤추가
	leafletAddPolygon();
	
	//원추가
	leafletAddCircle(37.572148, 126.976423);
	
	var popup = L.popup();

	function onMapClick(e) {
	    popup
	        .setLatLng(e.latlng)
	        .setContent("You clicked the map at " + e.latlng.toString())
	        .openOn(leafletMap);
	}

	leafletMap.on('click', onMapClick);
	
	//마커 추가
	function leafletAddMarker(lon, lat){
		//핀마커
		var marker = L.marker([lon, lat]).addTo(leafletMap);
		
		//팝업 클릭시
		marker.bindPopup("<b>오픈메이트</b>").openPopup();
	}
	
	//원추가
	function leafletAddCircle(lon, lat){
		//원
		var circle = L.circle([lon, lat], {
		    color: 'red',
		    fillColor: '#f03',
		    fillOpacity: 0.5,
		    radius: 500
		}).addTo(leafletMap);
		
		//팝업 클릭시
		circle.bindPopup("<b>시위를 많이하는곳</b>");
	}
	
	//폴리곤추가
	function leafletAddPolygon(){
		//폴리곤
		var polygon = L.polygon([
		    [37.553609, 126.972603], 	//서울역
		    [37.560133, 126.963687], 	//충정로역
		    [37.565830, 126.966650],	//서대문역	
		    [37.566230, 126.976809]		//시청역
		]).addTo(leafletMap);	
		
		//팝업 클릭시
		polygon.bindPopup("<b>주변 지하철역</b>");
	}
</script>