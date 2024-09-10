package Controller;

import Model.Admin;
import Model.Student;
import Repository.Repository;
import View.LoginView;
import View.RegisterAdminView;
import View.RegisterStudentView;
import View.RegisterView;

public class RegisterController {
    private RegisterView _view;
    private RegisterStudentView _studentView;
    private RegisterAdminView _adminView;
    private Repository _repository;

    public RegisterController(RegisterView view, Repository repository)
    {
        _view = view;
        _repository = repository;

        view.getRegisterStudentButton().setOnAction(e -> handleRegisterStudentButton());
        view.getRegisterAdminButton().setOnAction(e -> handleRegisterAdminButton());
        view.getBackToLoginButton().setOnAction(e -> handleBackToLogin());
    }

    public RegisterController(RegisterStudentView view, Repository repository, Student student)
    {
        _studentView = view;
        _repository = repository;

        view.getRegisterStudentButton().setOnAction(e -> handleRegisterStudentButton(student));
    }

    public RegisterController(RegisterAdminView view, Repository repository, Admin admin)
    {
        _adminView = view;
        _repository = repository;

        view.getRegisterAdminButton().setOnAction(e -> handleRegisterAdminButton(admin));
    }

    private void handleRegisterStudentButton() {
        String fullname = _view.getFullnameField().getText();
        String email = _view.getEmailField().getText();
        String password = _view.getPasswordField().getText();

        Student new_student = new Student(fullname, email, password);

        new RegisterController(new RegisterStudentView(_view.getStage()), _repository, new_student);
    }

    private void handleRegisterStudentButton(Student student)
    {
        _repository.addUser(student);

        new LoginController(new LoginView(_studentView.getStage()), _repository);
    }

    private void handleRegisterAdminButton() {
        String fullname = _view.getFullnameField().getText();
        String email = _view.getEmailField().getText();
        String password = _view.getPasswordField().getText();

        Admin new_admin = new Admin(fullname, email, password);

        new RegisterController(new RegisterAdminView(_view.getStage()), _repository, new_admin);
    }

    private void handleRegisterAdminButton(Admin admin) {
        _repository.addUser(admin);

        new LoginController(new LoginView(_adminView.getStage()), _repository);
    }

    private void handleBackToLogin() {
        new LoginController(new LoginView(_view.getStage()), _repository);
    }
}
