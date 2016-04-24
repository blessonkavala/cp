(function () {
    'use strict';
    angular.module('app.fundtransfer').controller('ControllerInitInternalFT', ControllerInitInternalFT);
    /* @ngInject */
    function ControllerInitInternalFT(screenFT,$state, $rootScope, $http,$stateParams) {
        /* jshint validthis: true */

        var vm = this;
        vm.formHeader = 'Initiate Internal Fundtransfer';
        vm.isNew =  true;
        vm.isView = false;
        vm.isEdit = false;
        
        vm.screenFT  = screenFT;
        vm.submitFT = function () {
            //TODO:
           $http.post('/ft/save',vm.screenFT).then(function(response){
        		$state.go('app.viewInternalFT',{rid: response.data.fundTransfer.rid});
        		console.log(response);
        	});
        	
        };
    }
})();