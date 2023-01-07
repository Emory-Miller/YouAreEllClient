import { IChannel } from 'app/shared/model/channel.model';
import { IMembership } from 'app/shared/model/membership.model';
import { IDirectMessage } from 'app/shared/model/direct-message.model';

export interface IMessage {
  id?: number;
  text?: string | null;
  channels?: IChannel[] | null;
  membership?: IMembership | null;
  directMessage?: IDirectMessage | null;
}

export const defaultValue: Readonly<IMessage> = {};
