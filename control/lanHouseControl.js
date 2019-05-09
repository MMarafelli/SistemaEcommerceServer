var app = angular.module('lanHouseModule',[]);
app.controller('lanHouseControl',function($scope,$http){

var url = 'http://localhost:8080/lanhouse';

$scope.pesquisar = function(){
	$http.get(url).then(function(response){

		$scope.lanHouseClientes = response.data;
	}, function(error){
		alert(error);
		console.log(error);

	});
	


}

$scope.pesquisar();



$scope.novo = function() {
	$scope.lanHouseCliente = {};
}

$scope.salvar = function() {
	if(typeof $scope.lanHouseCliente.codigo == 'undefined'){

		$http.post(url,$scope.lanHouseCliente).then(function(response){
			$scope.novo();

		}, function (error){
			alert(error);
			console.log(error);
		})
	} else{

		$http.put(url,$scope.lanHouseCliente).then(function(){
			$scope.pesquisar();
			$scope.novo();

		},function(error){

			alert(error);
			console.log(error);
		});
	}
	
}

$scope.excluir = function() {
	if($scope.lanHouseCliente.codigo==''){

		alert('escolha um cliente da lan house');
	}else{
		urlExcluir = url+"/"+$scope.lanHouseCliente.codigo;
		$http.delete(urlExcluir).then(function(){

			$scope.pesquisar();
			$scope.novo();
		}, function(error){

			alert(error);
			console.log(error);
		});


	}

}

$scope.seleciona = function(lanHouseCliente) {
	$scope.lanHouseCliente = lanHouseCliente;
}

});