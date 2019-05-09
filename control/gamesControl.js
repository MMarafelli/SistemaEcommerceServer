var app = angular.module('gamesModule', []);
app.controller('gamesControl', function ($scope, $http) {

	var url = 'http://localhost:8080/games';

	$scope.pesquisar = function () {
		$http.get(url).then(function (response) {

			$scope.games = response.data;
		}, function (error) {
			alert(error);
			console.log(error);

		});



	}

	$scope.pesquisar();

	/*$scope.clientes =[
	
	{
	'codigo':'1',
	 'nome':'carlos',
	 'cargo':'professor',
	 'endereco':'Rua teste,65,jardim das palmeiras',
	 'cidade':'uberlândia',
	 'cep':'38400-000',
	 'pais':'brasil',
	 'telefone':'3333333333',
	 'fax':'3233232323'},
	 {
		  'codigo':'2',
		  'nome':'Martin Fower',
		  'cargo':'ceo',
		  'endereco':'40,street view, google',
		  'cidade':'miami',
		  'cep':'49494949',
		  'pais':'usa',
		  'telefone':'3333333333',
		  'fax':'3233232323'
	 }
	] */




	$scope.novo = function () {
		$scope.game = {};
	}

	$scope.salvar = function () {
		if (typeof $scope.game.codigo == 'undefined') {

			$http.post(url, $scope.game).then(function (response) {
				$scope.novo();

			}, function (error) {
				alert(error);
				console.log(error);
			})
		} else {

			$http.put(url, $scope.game).then(function () {
				$scope.pesquisar();
				$scope.novo();

			}, function (error) {

				alert(error);
				console.log(error);
			});
		}

	}

	$scope.excluir = function () {
		if ($scope.game.codigo == '') {

			alert('escolha game');
		} else {
			urlExcluir = url + "/" + $scope.game.codigo;
			$http.delete(urlExcluir).then(function () {

				$scope.pesquisar();
				$scope.novo();
			}, function (error) {

				alert(error);
				console.log(error);
			});


		}
		//$scope.clientes.splice($scope.clientes.indexOf($scope.cliente),1);
		//$scope.novo();

	}

	$scope.seleciona = function (game) {
		$scope.games = game;
	}

});