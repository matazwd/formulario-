
function validarFormulario(event) {

    event.preventDefault(); 
    
   
    let formularioValido = true;


    const nome = document.getElementById('nome').value.trim();
    const email = document.getElementById('email').value.trim();
    const senha = document.getElementById('senha').value;
    const confirmaSenha = document.getElementById('confirma-senha').value;
    const dataNascimento = document.getElementById('data-nascimento').value;

    document.querySelectorAll('.erro-mensagem').forEach(el => el.textContent = '');
    document.querySelectorAll('input').forEach(el => el.classList.remove('invalido'));

    function mostrarErro(campoId, mensagem) {
        document.getElementById(`erro-${campoId}`).textContent = mensagem;
        document.getElementById(campoId).classList.add('invalido');
        formularioValido = false;
    }

    

    
    if (nome.length < 3) {
        mostrarErro('nome', 'O nome deve ter pelo menos 3 caracteres.');
    }

   
    const regexEmail = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!regexEmail.test(email)) {
        mostrarErro('email', 'Por favor, insira um e-mail válido.');
    }

    
    if (senha.length < 6) {
        mostrarErro('senha', 'A senha deve ter pelo menos 6 caracteres.');
    }

   
    if (confirmaSenha !== senha) {
       
        if (senha.length >= 6) { 
            mostrarErro('confirma-senha', 'As senhas não coincidem.');
        }
    }

   
    if (dataNascimento === "") {
         mostrarErro('data-nascimento', 'Campo Data de Nascimento é obrigatório.');
    } 

    

    if (formularioValido) {
        
        alert('Cadastro realizado com sucesso! (O formulário não foi realmente enviado, apenas validado no cliente)');
         
    } else {
        
        console.log('Formulário possui erros de validação.');
    }

    return formularioValido; 
}