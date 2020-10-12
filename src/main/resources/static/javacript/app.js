// Create APP 
var app = angular.module("myApp", ["ngRoute", "ngCookies"]);

// Loading Page
app.config(function ($routeProvider) {
  $routeProvider
    .when('/index.html', {
      templateUrl: 'index.html',
      controller: 'subjectCtrl'
    })
    .otherwise({
      redirectTo: '/'
    });
});

app.run(function ($rootScope) {
  $rootScope.$on('$routeChangeStart', function () {
    $rootScope.loading = true;
  });
  $rootScope.$on('$routeChangeSuccess', function () {
    $rootScope.loading = false;
  });
  $rootScope.$on('$routeChangeError', function () {
    $rootScope.loading = false;
    alert("Lỗi");
  });
});
// Subject Controller
app.controller("subjectCtrl", function ($scope, $http, $cookies) {

  
    // Tạo giá trị ban đầu list_subject là một mảng
    $scope.list_subject = [];
  
    /* Dùng phương thức get để lấy dữ liệu từ file Subjects.js ra
    * Gán dữ liệu lấy được vào biến list_subject
    */
    $http.get('../dbproject.json').then(function (res) {
      $scope.list_subject = res.data.projects;
    });
  
    // Phân trang cho các khóa học
    /*
    * Đặt giá trị ban đầu của trang là 0
    * Số khóa học trên mỗi trang là 4
    * Đếm tổng các trang biết độ dài mảng chia sô khóa học trên trang.
    */
    $scope.begin = 0;
    $scope.pageSize = 12;
    $scope.pageCount = Math.ceil($scope.list_subject.length / $scope.pageSize);
  
    // Trang đầu tiên
    $scope.first = function () {
      $scope.begin = 0;
    }
  
    // Lùi một trang
    $scope.prev = function () {
      $scope.pageCount = Math.ceil($scope.list_subject.length / $scope.pageSize);
      if ($scope.begin > 0) {
        $scope.begin -= $scope.pageSize;
      }
    }
  
    // Tiến một trang
    $scope.next = function () {
      $scope.pageCount = Math.ceil($scope.list_subject.length / $scope.pageSize);
      if ($scope.begin < ($scope.pageCount - 1) * $scope.pageSize) {
        $scope.begin += $scope.pageSize;
      }
    }
  
    // Trang cuối cùng
    $scope.last = function () {
      $scope.begin = ($scope.pageCount - 1) * $scope.pageSize;
    }
  });





  app.controller("blogCtrl", function ($scope, $http, $cookies) {

  
    // Tạo giá trị ban đầu list_service là một mảng
    $scope.list_service = [];
  
    /* Dùng phương thức get để lấy dữ liệu từ file service.js ra
    * Gán dữ liệu lấy được vào biến list_service
    */
    $http.get('../dbproject.json').then(function (res) {
      $scope.list_service = res.data.blog;
    });
  
    // Phân trang cho các khóa học
    /*
    * Đặt giá trị ban đầu của trang là 0
    * Số khóa học trên mỗi trang là 4
    * Đếm tổng các trang biết độ dài mảng chia sô khóa học trên trang.
    */
    $scope.begin = 0;
    $scope.pageSize = 12;
    $scope.pageCount = Math.ceil($scope.list_service.length / $scope.pageSize);
 
    // Trang đầu tiên
    $scope.first = function () {
      $scope.begin = 0;
    }
  
    // Lùi một trang
    $scope.prev = function () {

      $scope.pageCount = Math.ceil($scope.list_service.length / $scope.pageSize);
      if ($scope.begin > 0) {
        $scope.begin -= $scope.pageSize;
      }
    }
  
    // Tiến một trang
    $scope.next = function () {
      $scope.pageCount = Math.ceil($scope.list_service.length / $scope.pageSize);
      if ($scope.begin < ($scope.pageCount - 1) * $scope.pageSize) {
        $scope.begin += $scope.pageSize;
      }
    }
  
    // Trang cuối cùng
    $scope.last = function () {
      $scope.begin = ($scope.pageCount - 1) * $scope.pageSize;
    }
  });




  app.controller("serviceCtrl", function ($scope, $http, $cookies) {

  
    // Tạo giá trị ban đầu list_service là một mảng
    $scope.list_service = [];
  
    /* Dùng phương thức get để lấy dữ liệu từ file service.js ra
    * Gán dữ liệu lấy được vào biến list_service
    */
    $http.get('../dbproject.json').then(function (res) {
      $scope.list_service = res.data.services;
    });
  
    // Phân trang cho các khóa học
    /*
    * Đặt giá trị ban đầu của trang là 0
    * Số khóa học trên mỗi trang là 4
    * Đếm tổng các trang biết độ dài mảng chia sô khóa học trên trang.
    */
    $scope.begin = 0;
    $scope.pageSize = 12;
    $scope.pageCount = Math.ceil($scope.list_service.length / $scope.pageSize);
 
    // Trang đầu tiên
    $scope.first = function () {
      $scope.begin = 0;
    }
  
    // Lùi một trang
    $scope.prev = function () {

      $scope.pageCount = Math.ceil($scope.list_service.length / $scope.pageSize);
      if ($scope.begin > 0) {
        $scope.begin -= $scope.pageSize;
      }
    }
  
    // Tiến một trang
    $scope.next = function () {
      $scope.pageCount = Math.ceil($scope.list_service.length / $scope.pageSize);
      if ($scope.begin < ($scope.pageCount - 1) * $scope.pageSize) {
        $scope.begin += $scope.pageSize;
      }
    }
  
    // Trang cuối cùng
    $scope.last = function () {
      $scope.begin = ($scope.pageCount - 1) * $scope.pageSize;
    }
  });

  app.controller('registerCtrl', function ($scope, $http) {
    // $scope.users = {};
    $scope.addUser = function () {
      $http.post('http://localhost:3000/projects', {
        name: $scope.projects.name,
        category: $scope.projects.category,
        logo: $scope.projects.logo,
      })
        .then(function (response) {
          // $location.path('/');
          alert("Đăng ký thành công");
        })
        .catch(function (error) {
          $scope.errorMessage = "Add Failed!";
          // $location.path('/');
          alert("Đăng ký thất bai")
        });
    }
  });