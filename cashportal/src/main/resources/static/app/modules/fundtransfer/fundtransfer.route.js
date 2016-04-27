(function () {
    'use strict';
    angular.module('app.fundtransfer').run(appRun);

    /* @ngInject */
    function appRun(routerHelper) {
        routerHelper.configureStates(getStates());
    }

    function getStates() {
        return [
           {
                state: 'app.initInternalFT',
                config: {
                    url: '/initInternalFT',
                    views: {
                        'mainContent': {
                            templateUrl: 'app/modules/fundtransfer/internal/InternalFundtransferDetails.html',
                            controller: 'ControllerInitInternalFT as vm',
                        }
                    },
                    resolve: {
                        screenFT: screenFTResolve
                    }
                }
            },
            {
                state: 'app.listPendingFTs',
                config: {
                    url: '/listPendingFTs',
                    views: {
                    'mainContent': {
                        templateUrl: 'app/modules/fundtransfer/ListPendingFTs.html',
                        controller: 'ControllerListPendingFTs as vm'
                        }
                    },
                    params : {
                         tnxStatCode: "03"
                    },
                    resolve: {
                        pendingFTResponse: pendingFTsResolve
                    }
                }
            },
            {
                state: 'app.listInquiryFTs',
                config: {
                    url: '/listInquiryFTs',
                    views: {
                    'mainContent': {
                        templateUrl: 'app/modules/fundtransfer/ListInquiryFTs.html',
                        controller: 'ControllerListInquiryFTs as vm'
                        }
                    },
                    params : {
                         tnxStatCode: "04"
                    },
                    resolve: {
                        pendingFTResponse: pendingFTsResolve
                    }
                }
            },
            {
                state: 'app.viewInternalFT',
                config: {
                    url: '/viewInternalFT',
                    views: {
                    'mainContent': {
                        templateUrl: 'app/modules/fundtransfer/internal/InternalFundtransferDetails.html',
                        controller: 'ControllerViewInternalFT as vm'
                        }
                    },
                    params : {
                         rid: null
                    },
                    resolve: {
                        fundTransferDetails: getFundTransferDetailsResolve
                    }
                }
            }
        ];
    }
    
    function screenFTResolve(FundTransferService) {
    'ngInject';
        return FundTransferService.getNewInternalFundtransfer();
    }
    
    function pendingFTsResolve(FundTransferService,$stateParams){
     'ngInject';
     return FundTransferService.getPendingFundTransfers($stateParams.tnxStatCode);    
    }
    
    function getFundTransferDetailsResolve(FundTransferService,$stateParams){
     'ngInject';
     return FundTransferService.getFundTransferDetails($stateParams.rid);    
    }
    
})();