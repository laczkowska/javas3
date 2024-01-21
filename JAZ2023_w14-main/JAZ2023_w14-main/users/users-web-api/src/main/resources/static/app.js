const stompClient = new StompJs.Client({
    brokerURL: 'ws://localhost:8181/messages'
})
stompClient.activate();

// stompClient.onConnect = (frame) => {
//     console.log('Connected: ' + frame);
//     stompClient.subscribe('/queue/messages', (message) => {
//         handleIncommingMessage(message);
//     });
// };

// function disconnect() {
//     stompClient.deactivate();
//     console.log("Disconnected");
// }



// function sendMessage() {
//     stompClient.publish({
//         destination: "/app/chat",
//         body: JSON.stringify({'message': getMessage()})
//     });
// }


function handleIncommingMessage(message) {
    console.log(message.body)
    var messageArea = document.getElementById('messageArea');
    var newMessage = document.createElement('div');
    var jsonMessage = JSON.parse(message.body);
    newMessage.textContent = jsonMessage.message;
    messageArea.appendChild(newMessage);
}

function getMessage() {
    var messageInput = document.getElementById('messageInput');
    var message = messageInput.value;
    return message;
}
